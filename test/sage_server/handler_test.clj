(ns sage-server.handler-test
  (:require [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [sage-server.handler :refer :all]))

(deftest test-app
  (testing "main route"
    (let [response (app (mock/request :get "/"))]
      (is (= (:status response) 200))
      (is (= (:body response) "Welcome to the homepage!"))))

  (testing "echo route"
    (let [response (app (mock/request :get "/echo/howdy"))]
      (is (= (:status response) 200))
      (is (= (:body response) "howdy"))))

  (testing "not-found route"
    (let [response (app (mock/request :get "/invalid"))]
      (is (= (:status response) 404)))))
