(ns coapd.services.test
  (:require [clojure.tools.logging :as log])
  (:import [de.uniluebeck.itm.ncoap.message CoapRequest CoapResponse MessageDoesNotAllowPayloadException]
           [de.uniluebeck.itm.ncoap.message.header Code]
           [de.uniluebeck.itm.ncoap.message.options OptionRegistry]
           [de.uniluebeck.itm.ncoap.application.server.webservice NotObservableWebService]))

(defn service [servicePath initialStatus]
  (proxy [de.uniluebeck.itm.ncoap.application.server.webservice.NotObservableWebService] [servicePath initialStatus]
    (processCoapRequest [res req addr]
      (log/info "Hello!!")
      (.set res (new CoapResponse Code/INTERNAL_SERVER_ERROR_500)))))

