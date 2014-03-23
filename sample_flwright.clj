{:version {:minor 0 :major 4 :patch 0}
 :instances {:root {:name "Root Instance"
                    :services {:auth {:type :auth
                                      :name "Auth"
                                      :log-level :info
                                      :options {:port 8082}
                                      :processes [:auth]}
                               :cxengage-api {:type :cxengage-api
                                              :name "CxEngage API"
                                              :log-level :info
                                              :options {:port 8081}
                                              :processes [:api]}
                               :cxengage-ui {:type :webapp
                                             :name "CxEngage UI"
                                             :log-level :info
                                             :options {:port 8079}
                                             :processes [:ui]}}
                    :nodes {:api {:name "prod-cxengage-api"
                                  :ip-address "192.168.0.21"
                                  :username "cxengage"
                                  :password "password"}
                            :auth {:name "prod-auth"
                                   :ip-address "192.168.0.22"
                                   :username "username"
                                   :password "password"}
                            :ui {:name "prod-ui"
                                 :ip-address "192.168.0.23"
                                 :username "username"
                                 :password "password"}}
                    :options {:auth "http://192.168.0.9:8082"
                              :events "http://192.168.0.10:8083"
                              :zk "zk1.liveops.com:2181,zk2.liveops.com:2181"
                              :redis "redis://redis.liveops.com:6379"
                              :api "http://api.liveops.com:8081"}}
             :my-instance {:name "My Instance"
                           :services {:datasift {:type :datasift
                                                 :name "Datasift listener"
                                                 :options {:pipeline-port 40000
                                                           :command-port 50000}
                                                 :log-level :debug
                                                 :processes [:datasift]}
                                      :salesforce-listener {:type :salesforce-listener
                                                            :name "Salesforce listener"
                                                            :options {:pipeline-port 40000
                                                                      :command-port 50000}
                                                            :log-level :debug
                                                            :processes [:salesforce-listener]}
                                      :rest {:type :rest
                                             :name "Rest Receiver"
                                             :options {:port 8083}
                                             :log-level :info
                                             :connections {:event-downstream :augment
                                                           :notification-downstream :n-broker}
                                             :processes [:rest]}
                                      :augment {:type :augment
                                                :name "Augment Service"
                                                :log-level :info
                                                :options {:pipeline-port 40000
                                                          :command-port 50000}
                                                :connections {:event-downstream :e-broker
                                                              :notification-downstream :n-broker}
                                                :processes [:augment]}
                                      :e-broker {:type :broker
                                                 :name "Engine Broker"
                                                 :options {:pipeline-port 40000
                                                           :command-port 50000}
                                                 :log-level :info
                                                 :connections {:downstream :engine}
                                                 :processes [:eBroker]}
                                      :engine {:type :engine
                                               :name "Engine"
                                               :log-level :info
                                               :options {:shelves 3
                                                         :pipeline-port 40000
                                                         :command-port 50000
                                                         :broker-port 30000}
                                               :connections {:downstream :n-broker}
                                               :processes [:engine1 :engine2 :engine3]}
                                      :n-broker {:type :broker
                                                 :name "Notification Broker"
                                                 :options {:pipeline-port 40000
                                                           :command-port 50000}
                                                 :log-level :info
                                                 :connections {:downstream :notification}
                                                 :processes [:nBroker]}
                                      :notification {:type :notification
                                                     :name "Notification"
                                                     :log-level :info
                                                     :options {:shelves 3
                                                               :pipeline-port 40000
                                                               :command-port 50000}
                                                     :connections {:downstream :es-journal}
                                                     :processes [:notification1 :notification2 :notification3]}
                                      :es-journal {:type :es-journal
                                                   :log-level :info
                                                   :name "Elastic Search Journal"
                                                   :options {:endpoints [["es1.liveops.com", 9300],
                                                                         ["es2.liveops.com", 9300],
                                                                         ["es3.liveops.com", 9300]]
                                                             :cluster-name "CxEngage"
                                                             :pipeline-port 40000
                                                             :command-port 50000}
                                                   :processes [:journal]}
                                      :salesforce {:type :salesforce
                                                   :name "Salesforce Endpoint"
                                                   :options {:pipeline-port 40000
                                                             :command-port 50000}
                                                   :log-level :debug
                                                   :processes [:salesforce]}
                                      :sendgrid {:type :sendgrid
                                                 :name "Sendgrid Endpoint"
                                                 :options {:pipeline-port 40000
                                                           :command-port 50000}
                                                 :log-level :debug
                                                 :processes [:sendgrid]}
                                      :pusher {:type :pusher
                                               :name "Pusher Endpoint"
                                               :options {:pipeline-port 40000
                                                         :command-port 50000}
                                               :log-level :debug
                                               :processes [:pusher]}
                                      :twilio {:type :twilio
                                               :name "Twilio Endpoint"
                                               :options {:pipeline-port 40000
                                                         :command-port 50000}
                                               :log-level :debug
                                               :processes [:twilio]}
                                      :urban-airship {:type :urban-airship
                                                      :name "Urban Airship Endpoint"
                                                      :options {:pipeline-port 40000
                                                                :command-port 50000}
                                                      :log-level :debug
                                                      :processes [:urban-airship]}
                                      :echo {:type :echo
                                             :name "Echo Endpoint"
                                             :options {:pipeline-port 40000
                                                       :command-port 50000}
                                             :log-level :debug
                                             :processes [:echo]}}
                                       :generic {:type :generic
                                             :name "generic Endpoint"
                                             :options {:pipeline-port 40000
                                                       :command-port 50000
                                                       :port 8086 }
                                             :log-level :debug
                                             :processes [:generic]}}

                           :nodes {:datasift {:name "prod-datasift"
                                              :ip-address "192.168.0.28"
                                              :username "cxengage"
                                              :password "password"}
                                   :salesforce-listener {:name "prod-salesforce-listener"
                                                         :ip-address "192.168.0.27"
                                                         :username "cxengage"
                                                         :password "password"}
                                   :rest {:name "prod-rest"
                                          :ip-address "192.168.0.26"
                                          :username "cxengage"
                                          :password "password"}
                                   :augment {:name "prod-augment"
                                             :ip-address "192.168.0.25"
                                             :username "cxengage"
                                             :password "password"}
                                   :eBroker {:name "prod-eBroker"
                                             :ip-address "192.168.0.24"
                                             :username "cxengage"
                                             :password "password"}
                                   :engine1 {:name "prod-engine-1"
                                             :ip-address "192.168.0.23"
                                             :username "cxengage"
                                             :password "password"}
                                   :engine2 {:name "prod-engine-2"
                                             :ip-address "192.168.0.22"
                                             :username "username"
                                             :password "password"}
                                   :engine3 {:name "prod-engine-3"
                                             :ip-address "192.168.0.21"
                                             :username "username"
                                             :password "password"}
                                   :nBroker {:name "prod-nBroker"
                                             :ip-address "192.168.0.20"
                                             :username "username"
                                             :password "password"}
                                   :notification1 {:name "prod-notification-1"
                                                   :ip-address "192.168.0.19"
                                                   :username "username"
                                                   :password "password"}
                                   :notification2 {:name "prod-notification"
                                                   :ip-address "192.168.0.18"
                                                   :username "username"
                                                   :password "password"}
                                   :notification3 {:name "prod-notification-3"
                                                   :ip-address "192.168.0.17"
                                                   :username "username"
                                                   :password "password"}
                                   :journal {:name "prod-journal"
                                             :ip-address "192.168.0.16"
                                             :username "username"
                                             :password "password"}
                                   :pusher {:name "prod-pusher"
                                            :ip-address "192.168.0.15"
                                            :username "username"
                                            :password "password"}
                                   :sendgrid {:name "prod-sendgrid"
                                              :ip-address "192.168.0.14"
                                              :username "username"
                                              :password "password"}
                                   :salesforce {:name "prod-salesforce"
                                                :ip-address "192.168.0.13"
                                                :username "username"
                                                :password "password"}
                                   :twilio {:name "prod-twilio"
                                            :ip-address "192.168.0.12"
                                            :username "username"
                                            :password "password"}
                                   :generic {:name "prod-generic"
                                             :ip-address "192.168.0.11"
                                             :username "username"
                                             :password "password"}
                                   :echo {:name "prod-echo"
                                          :ip-address "192.168.0.10"
                                          :username "username"
                                          :password "password"}}
                           :options {:auth "http://auth.liveops.com:8082"
                                     :zk "zk1.liveops.com:2181,zk2.liveops.com:2181,zk3.liveops.com:2181"
                                     :events "http://events.liveops.com:8083"
                                     :redis "redis://redis.liveops.com:6379"
                                     :api "http://api.liveops.com:8081"}}}
 :integrations #{:echo
                 :twilio
                 :datasift
                 :sendgrid
                 :salesforce
                 :pusher
                 :urban-airship
                 :demo}
 :tenants {:userevents {:name "UserEvents"
                        :instance :my-instance
                        :key-attr :username
                        :patterns [{:then (send echo message {:message "Hello World1"})
                                    :when (within 1 hours (count 2 (event (= type "echoo"))))
                                    :description "simple pattern"
                                    :status true
                                    :name "Two event echo"}
                                   {:then (send twilio call {:from-phone-number "15068009013"
                                                             :to-phone-number *to-phone-number*
                                                             :message "Welcome to 4.0"})
                                    :when (event (= type "callphone"))
                                    :status true
                                    :name "One event twilio"}
                                   {:then (send sendgrid email {:to *to-email-address*
                                                                :subject "Welcome to a wonderful experience"
                                                                :from "no-reply@cxengage.com"
                                                                :message +TM1})
                                    :when (event (= type "sendemail"))
                                    :status true
                                    :description "using welcome template"
                                    :name "One event sendgrid"}
                                   {:then (send salesforce task
                                                {:OwnerId "005d0000001LEROAA4"
                                                 :WhoId "003d000000iGNfwAAG"
                                                 :WhatId "001d000000UemMhAAJ"
                                                 :Status "Not Started"
                                                 :Priority "High"
                                                 :message "this is it 4 dot oh"
                                                 :Description "this is the description"
                                                 :Subject "this is from cxengage.net"
                                                 :ActivityDate "2013-11-01"
                                                 :StageName "Prospecting"
                                                 :AccountId "001d000000W9YdOAAV"
                                                 :CloseDate "2013-10-29"})
                                    :when (event (= type "salesforce"))
                                    :status true
                                    :name "salesforce"}
                                   {:then (send sendgrid email {:to *email*
                                                                :subject "Welcome to a wonderful experience"
                                                                :from "no-reply@cxengage.com"
                                                                :message +TM1})
                                    :when (event (or (= username "suhaim_a") (= username "trevorbernard")))
                                    :status true
                                    :name "One event datasift"}
                                   {:then (send twilio call {:from-phone-number "15068009013"
                                                             :to-phone-number *to-phone-number*
                                                             :message "Welcome to 4.0"})
                                    :when (event (= product "401k"))
                                    :status true
                                    :name "One event sf listener"}
                                   {:then (send twilio call {:from-phone-number "15068009013"
                                                             :to-phone-number "15062592237"
                                                             :message "hello"})
                                    :when (event (= type "callphone"))
                                    :status true
                                    :description "This appears to call Suhaim"
                                    :name "phoneyou"}
                                   {:then (seq  (send echo message {}
                                                      (template {:message +TM3}))
                                               (delay 5 seconds)
                                               (send echo message {:message "Hello World2"}))
                                    :when (event (= type "testing"))
                                    :status true
                                    :description "My First Pattern"
                                    :name "My First Pattern"}]
                        :templates [{:name "Welcome"
                                     :template "Hi\n\nWelcome to the 4.0 version of CxEngage!\n"
                                     :description "sample description"}
                                    {:name "message templates"
                                     :template "hello {{firstNameFirst}}, we should call you at {{telNbr}} during the {{timeZone}} time zone."
                                     :description "description of a message template"}
                                    {:name "Hello World"
                                     :template "Hello World {{fName}}"
                                     :description "Hello World"}]
                        :integrations {:echo {}
                                       :twilio {:account "account"
                                                :password "password"}
                                       :datasift {:api-key "key"
                                                  :username "username"}
                                       :pusher {:key "key"
                                                :secret "secret"}
                                       :demo {}
                                       :urban-airship {:account "cxengage"
                                                       :password "ue@password"}
                                       :sendgrid {:account "userevents"
                                                  :password "password"}}
                        :listeners [{:name "sentiment listener",
                                     :type "datasift",
                                     :description "something"
                                     :status true,
                                     :mapping {:username "interaction.author.username",
                                               :retweet-count "twitter.retweet.count",
                                               :network "interaction.type",
                                               :sentiment "salience.content.sentiment",
                                               :followers "twitter.user.followers_count",
                                               :user-url "interaction.author.link",
                                               :profile-image "twitter.user.profile_image_url"},
                                     :options {:hash "hash value"}}
                                    {:name "My Salesforce Listener",
                                     :type :salesforce,
                                     :description "stuff"
                                     :status true,
                                     :options {:topic "push_topic"},
                                     :mapping {:user "user__c",
                                               :type "Type",
                                               :stage "StageName",
                                               :amount "Amount",
                                               :daystoclose "daysToClose__c",
                                               :product "Product__c"}}]}
           :qa {:name "qa"
                :instance :my-instance
                :key-attr :id
                :integrations {:echo {}
                               :twilio {:account "username"
                                        :password "password"}
                               :datasift {:api-key "key"
                                          :username "username"}
                               :salesforce {:consumer-key "key"
                                            :consumer-secret "secret"
                                            :username "username@liveops.com"
                                            :password "password"
                                            :secret-token "token"
                                            :instance "na18"}
                               :pusher {:key "key"
                                        :secret "secret"}}
                :patterns [{:name "Test Pattern"
                            :status true
                            :when (event (= type "a"))
                            :then (send echo message {:message "Hello World"})}
                           {:name "EventMatch"
                            :status true
                            :when (event (and (= type "match")(= segment "platinum")))
                            :then (seq (send echo message {}
                                             (template {:message (TM :test-message)})))}
                           {:name "EventMatch2"
                            :status true
                            :when (event (and (= type "match2")(= segment "platinum")))
                            :then (seq (send echo message {}
                                             (template {:message (TM :test-message)})))}
                           {:name "EventMatch3"
                            :status true
                            :when (event (and (= type "match3")(= segment "platinum")))
                            :then (seq (send echo message {}
                                             (template {:message (TM :test-message)})))}
                           {:name "EventMatch4"
                            :status true
                            :when (event (and (= type "match4")(= segment "platinum")))
                            :then (seq (send echo message {}
                                             (template {:message (TM :test-message)})))}
                           {:name "EventMatch5"
                            :status true
                            :when (event (and (= type "match5")(= segment "platinum")))
                            :then (seq (send echo message {}
                                             (template {:message (TM :test-message)})))}
                           {:name "NoEventMatch6"
                            :status true
                            :when (event (and (= type "nomatch6")(= segment "platinum")))
                            :then (seq (send echo message {}
                                             (template {:message (TM :fail-message)})))}
                           {:name "NoEventMatch7"
                            :status true
                            :when (event (and (= type "nomatch7")(= segment "platinum")))
                            :then (seq (send echo message {}
                                             (template {:message (TM :fail-message)})))}
                           {:name "NoEventMatch8"
                            :status true
                            :when (event (and (= type "nomatch8")(= segment "platinum")))
                            :then (seq (send echo message {}
                                             (template {:message (TM :fail-message)})))}
                           {:name "Test Pattern 2"
                            :status true
                            :when (count 3 (event (= type "b")))
                            :then (seq (send echo message {}
                                             (template {:message (TM :count-message)})))}]
                :templates {:test-message {:name "Test Template"
                                           :template "T1 - Hello {{id}}"}
                            :fail-message {:name "Fail Template"
                                           :template "T1 - Something Went Wrong {{id}}"}
                            :count-message {:name "Count Template"
                                            :template "T1 - You sent 3 messages to generate this message {{id}}"}}}}
 :users [{:name "qa"
          :email "dev@userevents.com"
          :password "Password1"
          :tenants [:qa :sales :staging]}
         {:name "Admin"
          :email "admin@liveops.com"
          :password "Password"
          :tenants [:userevents]}]}
