(ns coapd.services.test.class
  (:require [clojure.tools.logging :as log])
  (:import [de.uniluebeck.itm.ncoap.message CoapRequest CoapResponse MessageDoesNotAllowPayloadException]
           [de.uniluebeck.itm.ncoap.message.header Code]
           ;[de.uniluebeck.itm.ncoap.message Option UintOption]
           [de.uniluebeck.itm.ncoap.message.options OptionRegistry]
           [de.uniluebeck.itm.ncoap.application.server.webservice NotObservableWebService])
  (gen-class :extends NotObservableWebService :main false))

(defn -processCoapRequest [res req addr]
  (log/info "Hello!!")
  (.set res (new CoapResponse Code/INTERNAL_SERVER_ERROR_500)))

(ns coapd.services.test
  (:use coapd.services.test.class))

(defn service [servicePath initialStatus]
  (proxy [de.uniluebeck.itm.ncoap.application.server.webservice.NotObservableWebService] [servicePath initialStatus]
    (processCoapRequest [res req addr] (-processCoapRequest this res req addr))))

