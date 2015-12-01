(ns petrol-examples.spotify.rest
  (:require [cljs-http.client :as http]
            [petrol.core :as petrol]
            [petrol-examples.spotify.events :as e]))

(defn search-songs
  [term]
  (petrol/cmap e/map->SearchResults
               (http/get "https://api.spotify.com/v1/search"
                         {:with-credentials? false
                          :query-params {:q term
                                         :type "track"}})))