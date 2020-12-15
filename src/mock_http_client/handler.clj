
(ns mock-http-client.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults api-defaults]]))

(defroutes app-routes
  (GET "/" [] "Hello World")
  (POST "/poi-osm/_msearch" [req]
       (println "Calling Mock multiquery. The request is: " req)
       (Thread/sleep 11000)
       
       {:status 200
        :body "Sleepy"})
  

(route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes api-defaults))
