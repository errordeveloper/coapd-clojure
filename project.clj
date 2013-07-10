(defproject coapd "0.1.0-SNAPSHOT"

  :min-lein-version "2.0.0"

  :dependencies [
                 [org.clojure/clojure "1.5.1"]
                 [compojure "1.1.5"]
                 [org.clojure/tools.logging "0.2.6"]
                 [clj-mvn "0.1.0"]
                 ;; copied from okleine/nCoAP@12f1b0eee97d4f01e5d8b6742e1d91ee4841d5b1
                 [org.slf4j/slf4j-api "1.6.6"]
                 [org.jboss.netty/netty "3.2.8.Final"]
                 [com.google.guava/guava "14.0.1"]
                 [org.slf4j/slf4j-log4j12 "1.6.6"]
                ]

  :source-paths ["src"]

  :java-source-paths ["../nCoAP/src/main/java"]

  :repositories {"typesafe" {:url "http://repo.typesafe.com/typesafe/releases"
                             :snapshots false
                             :releases {:checksum :fail :update :always}}
                 "sonatype" {:url "http://oss.sonatype.org/content/repositories/releases"
                             :snapshots false
                             :releases {:checksum :fail :update :always}}
                 "sonatype-snapshots" {:url "http://oss.sonatype.org/content/repositories/snapshots"
                                       :snapshots true
                                       :releases {:checksum :fail :update :always}}}

  :main coapd.core)
