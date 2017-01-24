(defproject
  tenzing3
  "0.2.0-SNAPSHOT"
  :dependencies
  [[adzerk/boot-cljs "1.7.228-2" :scope "test"]
   [adzerk/boot-cljs-repl "0.3.3" :scope "test"]
   [adzerk/boot-reload "0.4.13" :scope "test"]
   [pandeiro/boot-http "0.7.6" :scope "test"]
   [com.cemerick/piggieback "0.2.1" :scope "test"]
   [org.clojure/tools.nrepl "0.2.12" :scope "test"]
   [weasel "0.7.0" :scope "test"]
   [org.clojure/clojurescript "1.9.293"]]
  :source-paths
  ["src/cljs" "resources"])
