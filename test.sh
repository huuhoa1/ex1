curl -X POST localhost:8080/subscriptions -H 'Content-type:application/json' -d '{"customerName": "Samwise Gamgee", "tarifName": "tarifDyna1"}'
curl -v localhost:8080/subscriptions
curl -v localhost:8080/subscriptions/1
curl -X PUT localhost:8080/subscriptions/3 -H 'Content-type:application/json' -d '{"customerName": "Samwise Gamgee", "tarifName": "tarifD"}'
curl -X PUT localhost:8080/subscriptions/4 -H 'Content-type:application/json' -d '{"customerName": "Can Gamgee", "tarifName": "tarifD"}'
curl -X DELETE localhost:8080/subscriptions/3
#  customers
curl localhost:8081/customers
curl localhost:8081/customers/
curl localhost:8081/customers/1
curl localhost:8081/customers/2
curl -X POST localhost:8081/customers -H 'Content-type:application/json' -d '{"customerName": "Samwise Gamgee", "address": "64 bvd Magenta, Longueuil, QC, j4X1N9"}'
curl localhost:8081/customers/3
curl -X PUT localhost:8081/customers/3 -H 'Content-type:application/json' -d '{"customerName": "Samwise Gamgee", "address": "66 bvd Magenta, Longueuil, QC, j4X1N9"}'
curl localhost:8081/customers/4
curl -X DELETE localhost:8081/customers/3
curl localhost:8081/customers/3
curl localhost:8081/customers
# tarif
curl localhost:8082/tarifs
curl localhost:8082/tarifs/
curl localhost:8082/tarifs/1
curl localhost:8082/tarifs/2
curl -X POST localhost:8082/tarifs -H 'Content-type:application/json' -d '{"tarifName": "tarifA"}'
curl -X PUT localhost:8082/tarifs/6 -H 'Content-type:application/json' -d '{"tarifName": "tarifB"}'
curl -X DELETE localhost:8082/tarifs/6

