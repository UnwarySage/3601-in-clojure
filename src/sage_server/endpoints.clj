(ns sage-server.endpoints)

(def base-response {:status 200
                    :headers {"Content-type" "text/plain"}})

(defn homepage [inp-request]
  (assoc base-response :body "Welcome to the homepage!"))

(defn echo [inp-request]
  (assoc base-response :body (str (get-in inp-request [:params :word]))))
