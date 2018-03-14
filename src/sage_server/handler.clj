(ns sage-server.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            ;;The endpoints file
            [sage-server.endpoints :as endpoints]
            ;;needed to return static files
            [clojure.java.io :as io]))

(def public-resource-path "resources/public")

(defroutes app-routes
  (GET "/" [] endpoints/homepage)
  (GET "/echo/:word" [word] endpoints/echo)
  (GET "/faculty" [] (io/file public-resource-path "faculty.html"))
  (GET "/help" [] (io/file public-resource-path "help.html"))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
