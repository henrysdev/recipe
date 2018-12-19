(ns recipe.persistence
  (:gen-class)
  (:require [recipe.db :refer [db]]
            [recipe.sql :as sql]))

(defn user-login [user]
  (println "inserting refresh token into DB by lookup User ID")
  (if (= () (sql/user-exists? db {:user_id (:user_id user)}))
    (sql/login-new-user db user)
    (sql/login-old-user db user)))
