(ns coapd.core
  (:use compojure.core)
  (:require [compojure.route :as route]
            [coapd.services.test :as test-service]
            [clojure.tools.logging :as log])
  (:import [de.uniluebeck.itm.ncoap.application.server CoapServerApplication]))

(defn- create-server []
  (doto (CoapServerApplication.)
    (.registerService (test-service/service "/test" 300000))))

(defn -main
  [& args]
  (log/info "Hello!!")
  (create-server))
