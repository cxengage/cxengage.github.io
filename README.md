# Using the CxEngage API

## Authentication 

How to authenticate with CxEngage API - [http://docs.cxengage.com/docs/authentication](http://docs.cxengage.com/docs/authentication/)


## CxEngage API 1.0
url - https://api.cxengage.net/
version - 1.0

## Error Codes

CxEngage API uses HTTP response codes for showing failure of API requests.

**HTTP 400**
```
Required fields are not present
```
**HTTP 401**
```
Incorrect credentials
```
**HTTP 403**
```
User does not have access to selected tenant
```
**HTTP 404** 
```
The selected tenant or item does not exist
```


## Tenants

Retrieve Tenant info

**Request**

```http
GET /1.0/tenants/{{tenant-name}} HTTP/1.1
Host: api.cxengage.net
Authorization: Bearer {{token}}
```
**Response**

```json

{
    "id": "tenant1",
    "name": "Tenant Number One"
}

```

**curl Example**

```bash
curl -X GET https://api.cxengage.net/1.0/tenants/{{tenant-name}} \
     -H 'Authorization: Bearer {{token}}'
```


## Key Attribute

**Parameters**

key

```
Key attribute
```

**Retrieve key attribute for the given tenant**

Request
```http
GET /1.0/tenants/{{tenant-name}}/key-attribute HTTP/1.1
Host: api.cxengage.net
Content-Type: application/json
Authorization: Bearer {{token}}
Cache-Control: no-cache
```

Response

```json
{
    "key": "id"
}
```

curl Example

```bash
curl -X GET https://api.cxengage.net/tenants/{{tenant-name}}/key-attribute \
     -H 'Authorization: Bearer {{token}}'

```

**Update key attribute for the given tenant**

Request

```http
POST /tenants/{{tenant-name}}/key-attribute HTTP/1.1
Host: {{cxenage-api}}
Content-Type: application/json; charset=utf-8
Authorization: Bearer {{token}}
```

Response

```json
{
    "key": "username"
}
```
 
curl Example

```bash
curl -X POST https://api.cxengage.net/tenants/{{tenant-name}}/key-attribute \
 -H 'Authorization: Bearer {{token}}' \
 -H 'Content-Type: application/json; charset=utf-8' \
 -d '{"key" : "username"}' 
```

   
## Patterns

**Mandatory Parameters**

name 

```
Name of Pattern
```

**Optional Parameters**

description 
```
Description of pattern
```
status 
```
Boolean value. Set to true/false to enable/disable the pattern
```
when 
```
When portion of pattern
```
then 
```
Then portion of pattern
```

**Retrieves all patterns from chosen tenant**

Request

```http
GET /1.0/tenants/{{tenant-name}}/patterns HTTP/1.1
Host: api.cxengage.net
Content-Type: application/json
Authorization: Bearer {{token}}
Cache-Control: no-cache
```

Response

```json

  {
   "id": "PT1",
   "then": "(par (send echo message {:message \"We should probably call the customer\"}) 
                 (send echo message {:message \"We should probably call the customer now \"}))",
   "when": "(within 1 minutes (allOf (count 4 (event (and (= customerSegment \"Gold\") 
                                                          (= eventType \"flcheck\")))) 
                                              (event (and (= customerSegment \"Gold\") 
                                                          (= eventType \"cnclTicket\"))))))",
   "description": "Loyalty Pattern for Gold customers",
   "name": "Loyalty Pattern"
  }

```

**Create a pattern on the given tenant**

Request

```http
POST /1.0/tenants/{{tenant-name}}/patterns HTTP/1.1
Host: api.cxengage.net
Content-Type: application/json; charset=utf-8
Authorization: Bearer {{token}}
```

```json
{ 
  "name": "Sample Pattern",
  "description": "Sample",
  "status":true,
  "when": "(when (event (= id \"1234\")))",
  "then": "(seq (send echo message {:message \"Hello world\"}))"
}
```

Response

```json
{ 
  "id": "PT2",
  "name": "Sample Pattern",
  "description": "Sample",
  "status":true,
  "when": "(when (event (= \"id\" \"1234\")))",
  "then": "(seq (send echo message {:message \"Hello world\"}))"
}
```

curl Example

```bash
curl -X POST https://api.cxengage.net/1.0/tenants/{{tenant-name}}/patterns \
 -H 'Authorization: Bearer {{token}}' \
 -H 'Content-Type: application/json; charset=utf-8' \
 -d '{"then":"(send echo message {:message \"Hello curl\"})",
      "when":"(event (= type \"curl\"))","status":true,"name":"curl Pattern"}'
```


**Retrieves chosen pattern for the given tenant**

Request

```http
GET /1.0/tenants/{{tenant-name}}/patterns HTTP/1.1
Host: api.cxengage.net
Content-Type: application/json
Authorization: Bearer {{token}}
```

Response

```json
{
  "id":"PT2",
  "when":"(when (event (= \"id\" \"1234\")))",
  "then":"(seq (send echo message {:message \"Hello world\"}))",
  "status":true,
  "description":"Sample Pattern",
  "name":"Sample Pattern"
}
```
curl Example

```bash
curl -XGET https://api.cxengage.net/tenants/{{tenant-name}}/patterns \
     -H 'Authorization: Bearer {{token}}'
```


**Update chosen pattern**

Request

```http
PUT /1.0/tenants/{{tenant-name}}/patterns/PT5 HTTP/1.1
Host: api.cxengage.net
Content-Type: application/json; charset=utf-8
Authorization: Bearer {{token}}
Cache-Control: no-cache

```

```json
{
"then" : "(send sendgrid email {:to *email*, :subject \"Welcome to a wonderful put experience\"})"
}
```

Response

```json

{"id":"PT5",
"then":"(send sendgrid email {:to *email*, :subject \"Welcome to a wonderful put experience\"})",
"when":"(event (or (= username \"cxengage\")))",
"status":true,
"name":"Updated Pattern"
}    
```

curl Example
```bash
curl -X PUT https://api.cxengage.net/1.0/tenants/userevents/patterns/PT5 \
 -H 'Authorization: Bearer {{token}}' \
 -H 'Content-Type: application/json; charset=utf-8' \
 -d '{"then" : "(send sendgrid email {:to *email*, :subject \"Welcome to a wonderful put experience\"})"}'

```
   
## Templates

**Retrieves templates for the given tenant**

**Mandatory Parameters**

name 

```
Name of Template
```

**Optional Parameters**

template

```
Template to create
```

description

```
Description of template
```


Request

```http
GET /1.0/tenants/{{tenant-name}}/templates/TM1 HTTP/1.1
Host: api.cxengage.net
Content-Type: application/json; charset=utf-8
Authorization: Bearer {{token}}
Cache-Control: no-cache
```

Response

```json

    {
        "id": "TM1",
        "template": "Hi {{FirstName}}, sorry we missed your call. Call Joe at
+14153159430 re: 401K needs.",
        "description": "Default SMS message with click-to-call",
        "name": "SMS"
    }
```

curl Example

```bash
curl -XGET https://api.cxengage.net/tenants/{{tenant-name}}/templates/TM1 \
     -H 'Authorization: Bearer {{token}}'
```

**Update chosen template**

Request

```http
POST /1.0/tenants/{{tenant-name}}/templates HTTP/1.1
Host: api.cxengage.net
Content-Type: application/json; charset=utf-8
Authorization: Bearer {{token}}
Cache-Control: no-cache
```

```json
{
    "template": "Hi {{first-name}} We apologize for the inconvenience. Please contact us at {{email-address}}",
    "description": "SMS apologizing to customer",
    "name": "SMS"
}
```

Response

```json
{
    "id": "TM1",
    "template": "Hi {{first-name}} We apologize for the inconvenience. Please contact us at {{email-address}}",
    "description": "SMS apologizing to customer",
    "name": "SMS"
}
```

curl Example

```bash

curl -X POST https://api.cxengage.net/1.0/tenants/userevents/templates \
 -H 'Authorization: Bearer {{token}}' \
 -H 'Content-Type: application/json; charset=utf-8' \
 -d '{"template": "Welcome to CxEngage 4.0", "description" : "sample description", "name" : "Welcome"}'

```

**Retrieve chosen template**

Request

```http
GET /1.0/tenants/{{tenant-name}}/templates/TM1 HTTP/1.1
Host: api.cxengage.net
Content-Type: application/json; charset=utf-8
Authorization: Bearer {{token}}
Cache-Control: no-cache
```

Response

```json

{
    "id": "TM1",
    "template": "Hi {{FirstName}}, sorry we missed your call. Call Joe at
+14153159430 re: 401K needs.",
    "description": "Default SMS message with click-to-call",
    "name": "SMS"
}
```

curl Example

```bash
curl -XGET https://api.cxengage.net/tenants/{{tenant-name}}/templates/TM1 \
     -H 'Authorization: Bearer {{token}}'
```

**Update chosen template**

Request

```http
PUT /1.0/tenants/{{tenant-name}}/templates/TM1 HTTP/1.1
Host: api.cxengage.net
Content-Type: application/json; charset=utf-8
Authorization: Bearer {{token}}
Cache-Control: no-cache
```

```json
{
   
    "name": "Test Template"
}
```

Response

```json
{
    "id": "TM1",
    "template": "Hi {{first-name}}. We apologize for the inconvenience. Please contact us at {{email-address}}",
    "description": "SMS apologizing to customer",
    "name": "Test Template"
}
```

curl Example

```bash
curl -XPUT https://api.cxengage.net/1.0/tenants/{{tenant-name}}/templates/TM1 \
     -H 'Authorization: Bearer {{token}}' \
     -H 'Content-Type: application/json; charset=utf-8' \
     -d '{"name":"Test Template"}'
```

**Delete chosen template**

Request

```http
DELETE /1.0/tenants/{{tenant-name}}/templates/TM1 HTTP/1.1
Host: api.cxengage.net
Content-Type: application/json; charset=utf-8
Authorization: Bearer {{token}}
Cache-Control: no-cache
```

Response

```json
{

  "TM1"
}
```

curl Example

```bash
curl -IX DELETE https://api.cxengage.net/tenants/{{tenant-name}}/templates/TM1 \
 -H 'Authorization: Bearer {{token}}' \ 
```

 

## Listeners

**Retrieve listeners**

Request

```http
GET /1.0/tenants/{{tenant-name}}/listeners HTTP/1.1
Host: api.cxengage.net
Content-Type: application/json
Authorization: Bearer {{token}}
Cache-Control: no-cache
```

Response

```json

[
    {
        "status": true,
        "topic": "CxDemo_0720v2",
        "name": "My Salesforce Listener",
        "version": "26.0",
        "type": "salesforce",
        "mapping": {
            "user": "user__c",
            "type": "Type",
            "stage": "StageName",
            "amount": "Amount",
            "daystoclose": "daysToClose__c",
            "product": "Product__c"
        },
        "id": "LI2"
     
    },
    {
        "id": "LI1",
        "name": "Demo Datasift",
        "type": "datasift",
        "mapping": {
            "username": "interaction.author.username",
            "sentiment": "salience.content.sentiment",
            "id": "twitter.user.screen_name"
        },
        "hash": "xxxxxxxxxxxxxx",
        "status": true
    }
]
```

curl Example
```bash
curl -XGET https://api.cxengage.net/tenants/{{tenant-name}}/listeners \ 
     -H 'Authorization: Bearer {{token}}'
```

**Create listener**

Request

```http
POST /1.0/tenants/{{tenant-name}}/listeners HTTP/1.1
Host: api.cxengage.net
Content-Type: application/json; charset=utf-8
Authorization: Bearer {{token}}
```

Salesforce Listener Example

Request

```
  POST tenants/tenant-name/listeners
```

```json

{
    "status": true,
    "topic": "CxDemo_0720v2",
    "name": "My Salesforce Listener",
    "version": "26.0",
    "type": "salesforce",
    "mapping": {
        "user": "user__c",
        "type": "Type",
        "stage": "StageName",
        "amount": "Amount",
        "daystoclose": "daysToClose__c",
        "product": "Product__c"
    } 
}
```
Response

```json
{
    "id": "LI3",
    "status": true,
    "topic": "CxDemo_0720v2",
    "name": "My Salesforce Listener",
    "version": "26.0",
    "type": "salesforce",
    "mapping": {
        "user": "user__c",
        "type": "Type",
        "stage": "StageName",
        "amount": "Amount",
        "daystoclose": "daysToClose__c",
        "product": "Product__c"
    }
}
```

curl Example

```bash
curl -XPOST https://api.cxengage.net/tenants/{{tenant-name}}/listeners \
     -H 'Authorization: Bearer {{token}}' \
-H 'Content-Type: application/json; charset=utf-8' \
-d '{"name":"My Salesforce Listener","type":"salesforce","mapping":{"user":"user__c","type":"Type", 
    "stage":"StageName","amount":"Amount","daystoclose":"daysToClose__c","product": "Product__c"},"status":true}'
```

Datasift Listener Example

**Request**

```http
POST /1.0/tenants/{{tenant-name}}/listeners HTTP/1.1
Host: api.cxengage.net
Content-Type: application/json; charset=utf-8
Authorization: Bearer {{token}}
```

```json

{
    "name": "sentiment listener",
    "type": "datasift",
    "mapping": {
        "username": "interaction.author.username",
        "retweet_count": "twitter.retweet.count",
        "network": "interaction.type",
        "sentiment": "salience.content.sentiment",
        "followers": "twitter.user.followers_count",
        "user_url": "interaction.author.link",
        "profile_image": "twitter.user.profile_image_url"
    },
    "hash": "datasifthash",
    "status": true
}
```
Response

```json
{
    "id": "LI1",
    "name": "sentiment listener",
    "type": "datasift",
    "mapping": {
        "username": "interaction.author.username",
        "retweet_count": "twitter.retweet.count",
        "network": "interaction.type",
        "sentiment": "salience.content.sentiment",
        "followers": "twitter.user.followers_count",
        "user_url": "interaction.author.link",
        "profile_image": "twitter.user.profile_image_url"
    },
    "hash": "datasifthash",
    "status": true
}
```

curl Example

```bash
curl -XPOST https://api.cxengage.net/tenants/{{tenant-name}}/listeners \
     -H 'Authorization: Bearer {{token}}' \
-H 'Content-Type: application/json; charset=utf-8' \
-d '{"name":"Demo Datasift","type":"datasift",
    "mapping":{"username":"interaction.author.username","sentiment":"salience.content.sentiment",
    "id":"twitter.user.screen_name"},"hash":{{{datasift-hash}},"status":true}'
```

**Retrieve chosen listener**

Request

```http
GET /1.0/tenants/{{tenant-name}}/listeners/LI4 HTTP/1.1
Host: api.cxengage.net
Content-Type: application/json
Authorization: Bearer {{token}}
Cache-Control: no-cache
```

Response

```json

{
        "status": true,
        "topic": "CxDemo_0720v2",
        "name": "My Salesforce Listener",
        "version": "26.0",
        "type": "salesforce",
        "mapping": {
            "user": "user__c",
            "type": "Type",
            "stage": "StageName",
            "amount": "Amount",
            "daystoclose": "daysToClose__c",
            "product": "Product__c"
        },
        "id": "LI4"
     
}
```

curl Example

```bash
curl -XGET https://api.cxengage.net/tenants/{{tenant-name}}/listeners/LI4 \
     -H 'Authorization: Bearer {{token}}'  
```

**Update chosen listener**

Request

```http
PUT /1.0/tenants/{{tenant-name}}/listeners/LI4 HTTP/1.1
Host: api.cxengage.net
Content-Type: application/json; charset=utf-8
Authorization: Bearer {{token}}
Cache-Control: no-cache
```

```json

  {"name" : "Updated Name for listener"}
    
```

Response

```json

{
    "id": "LI4",
    "status": false,
    "topic": "CxDemo_0720v2",
    "name": "Updated Name for listener",
    "version": "26.0",
    "type": "salesforce",
    "mapping": {
        "user": "user__c",
        "type": "Type",
        "stage": "StageName",
        "amount": "Amount",
        "daystoclose": "daysToClose__c",
        "product": "Product__c"
    }
}

```

curl Example

```bash
curl -XPUT https://api.cxengage.net/tenants/{{tenant-name}}/listeners/LI4 \
     -H 'Authorization: Bearer {{token}}' \
-H 'Content-Type: application/json; charset=utf-8' \
-d '{"name":"Updated Name for listener"}'
```

**Delete chosen listener**

Request

```http
DELETE /1.0/tenants/{{tenant-name}}/listeners/LI54 HTTP/1.1
Host: api.cxengage.net
Content-Type: application/json; charset=utf-8
Authorization: Bearer {{token}}
Cache-Control: no-cache

```

curl Example

```bash
curl -I -XDELETE https://api.cxengage.net/tenants/{{tenant-name}}/listeners/LI54 \
     -H 'Authorization: Bearer {{token}}'  
```


## Integrations

**Retrieve integrations from tenant**

  
Request

```http
GET /1.0/tenants/{{tenant-name}}/integrations HTTP/1.1
Host: api.cxengage.net
Content-Type: application/json
Authorization: Bearer {{token}}
Cache-Control: no-cache
```

Response

```json
[
  {
    "id": "datasift",
    "api-key": "keyvalue",
    "username": "usernamevalue"
}

    {
        "id": "echo"
    }
]
```

curl Example

```bash
curl -XGET https://api.cxengage.net/tenants/{{tenant-name}}/integrations \
     -H 'Authorization: Bearer {{token}}'
```

**Create specific integrations**

__Salesforce Example__

Salesforce Parameters

secret-token
```
Salesforce secret token
```
username 
```
Salesforce username
```
password 
```
Salesforce password
```
consumer-key 
```
Salesforce Consumer key/secret
```
consumer-secret 
```
Salesforce Consumer key/secret
```

Request

```http
POST /1.0/tenants/{{tenant-name}}/salesforce HTTP/1.1
Host: api.cxengage.net
Content-Type: application/json; charset=utf-8
Authorization: Bearer {{token}}
```

```json
{
    "id": "salesforce",
    "type": "salesforce",
    "consumer-key": "consumerkey",
    "consumer-secret": "consumersecret",
    "username": "dev@userevents.com",
    "secret-token": "secret-token",
    "password": "password"
}
```

Response

```json

{
    "id": "salesforce",
    "type": "salesforce",
    "consumer-key": "consumerkey",
    "consumer-secret": "consumersecret",
    "username": "email@userevents.com",
    "secret-token": "secret-token",
    "password": "password",

}
```

curl Example

```bash
curl -XPOST https://api.cxengage.net/1.0/tenants/{{tenant-name}}/integrations/salesforce \
     -H 'Authorization: Bearer {{token}}' \
-H 'Content-Type: application/json; charset=utf-8' \
-d '{"id": "salesforce", "type": "salesforce", "consumer-key": "consumerkey", 
     "consumer-secret":"consumersecret","username":"email@userevents.com"
     "secret-token":"secret-token","password":"password"}'

```

__Twilio Example__


Request

```http
POST /1.0/tenants/{{tenant-name}}/twilio HTTP/1.1
Host: api.cxengage.net
Content-Type: application/json; charset=utf-8
Authorization: Bearer {{token}}
```

Twilio Parameters

account  
```
Twilio SID
```
password 
```
Twilio Token
```


```json
{
    "id": "twilio",
    "account": "SID",
    "password": "Token"
}

```

Response

```json

{
    "id": "twilio",
    "account": "SID",
    "password": "Token"
}

```

curl Example

```bash
curl -XPOST https://api.cxengage.net/1.0/tenants/{{tenant-name}}/integrations/twilio \
     -H 'Authorization: Bearer {{token}}' \
-H 'Content-Type: application/json; charset=utf-8' \
-d '{"id": "twilio", "type": "twilio", "account": "SID", "password":"Token"}'
```

__Sendgrid Example__

Sendgrid Parameters
account 
```
SendGrid account 
```
password 
```
Sendgrid password
```


Request

```http
POST /1.0/tenants/{{tenant-name}}/sendgrid HTTP/1.1
Host: api.cxengage.net
Content-Type: application/json; charset=utf-8
Authorization: Bearer {{token}}
```

```json
{
    "id": "sendgrid",
    "account": "username",
    "password": "password"
}

```

Response

```json

{
    "id": "sendgrid",
    "account": "username",
    "password": "password"
}

```

curl Example

```bash
curl -XPOST https://api.cxengage.net/1.0/tenants/{{tenant-name}}/integrations/sendgrid \
     -H 'Authorization: Bearer {{token}}' \
-H 'Content-Type: application/json; charset=utf-8' \
-d '{"id": "sendgrid", "type": "sendgrid", "account": "username", "password":"password"}'

```

__Datasift Example__

Datasift Parameters

username 
```
DataSift username
```
api-key 

```
DataSift api key
```

Request

```http
POST /1.0/tenants/{{tenant-name}}/datasift HTTP/1.1
Host: api.cxengage.net
Content-Type: application/json; charset=utf-8
Authorization: Bearer {{token}}
```

```json
{
    "id": "datasift",
    "api-key": "api-key",
    "username": "username"
}

```

Response

```json

{
    "id": "datasift",
    "api-key": "api-key",
    "username": "username"
}

```

curl Example

```bash
curl -XPOST https://api.cxengage.net/1.0/tenants/{{tenant-name}}/integrations/datasift \
     -H 'Authorization: Bearer {{token}}' \
-H 'Content-Type: application/json; charset=utf-8' \
-d '{"id": "datasift", "type": "datasift", "api-key": "api-key", "username":"username"}'

```


__Pusher Example__

Pusher Parameters
key 
```
Pusher key 
```
secret 
```
Pusher secret
```


Request

```http
POST /1.0/tenants/{{tenant-name}}/pusher HTTP/1.1
Host: api.cxengage.net
Content-Type: application/json; charset=utf-8
Authorization: Bearer {{token}}
```

```json
{
    "id": "pusher",
    "key": "key",
    "secret": "secret"
}

```

Response

```json

{
    "id": "pusher",
    "key": "key",
    "secret": "secret"
}

```

curl Example

```bash
curl -XPOST https://api.cxengage.net/1.0/tenants/{{tenant-name}}/integrations/pusher \
     -H 'Authorization: Bearer {{token}}' \
-H 'Content-Type: application/json; charset=utf-8' \
-d '{"id": "pusher", "type": "pusher", "key": "key", "secret":"password"}'

```

**Retrieves specific integration from the given tenant**

Request

```http
GET /1.0/tenants/{{tenant-name}}/integrations/{{integration}} HTTP/1.1
Host: api.cxengage.net
Content-Type: application/json
Authorization: Bearer {{token}}
Cache-Control: no-cache
```

Response

```json
{
    "id": "salesforce",
    "type": "salesforce",
    "consumer-key": "consumerkey",
    "consumer-secret": "consumersecret",
    "username": "dev@userevents.com",
    "secret-token": "secret-token",
    "password": "password"
}
```

curl Example

```bash
curl -XGET https://api.cxengage.net/tenants/{{tenant-name}}/integrations/twilio \
     -H 'Authorization: Bearer {{token}}'
```
   
## Augments

**Retrieves augments for the given tenant**

Request

```http
GET /1.0/tenants/{{tenant-name}}/augments HTTP/1.1
Host: api.cxengage.net
Content-Type: application/json
Authorization: Bearer {{token}}
```

```json
[
    {
        "id": "AU1",
        "name": "Augment csv",
        "type": "file",
        "service": "engine"
    },
    {
        "description": "Sample description",
        "id": "AU5",
        "name": "Augment csv",
        "type": "file",
        "service": "engine"
    }
]
```
 
curl Example

```bash
curl -X GET https://api.cxengage.net/tenants/{{tenant-name}}/augments \
     -H 'Authorization: Bearer {{token}}'

```

**Create an Augment for a tenant**

**Mandatory Parameters**

name 
```
Name of Augment
```

type 
```
file or api based augment
```
service 
```
engine or notification
```

**Optional Parameters**

options 
```
Map of optional attributes shown below  
```
url 
```
url of the augment api
```
attributes 
```
Attributes that would get augmented
```

Request

```
POST /1.0/tenants/{{tenant-name}}/augments HTTP/1.1
Host: api.cxengage.net
Content-Type: application/json; charset=utf-8
Authorization: Bearer {{token}}
Cache-Control: no-cache
```

```json
{
    "service": "engine",
    "name": "rest augment api",
    "description": "description",
    "augment-service": "engine",
    "type": "api",
    "options": {
        "url": "hostname",
        "attributes": [
            "customerSegment"
        ]
    }
}
```


Response

```json
{
    "service": "engine",
    "id": "AU2",
    "name": "rest augment api",
    "description": "description",
    "augment-service": "engine",
    "type": "api",
    "options": {
        "url": "hostname",
        "attributes": [
            "customerSegment"
        ]
    }
}
```

curl Example

```bash
curl -X POST https://api.cxengage.net/tenants/{{tenant-name}}/augment \
 -H 'Authorization: Bearer {{token}}' \
 -H 'Content-Type: application/json; charset=utf-8' \
 -d '{"service": "engine", "id": "AU2", "name": "rest augment api", 
      "description": "describe", "augment-service": "engine", "type": "api", 
      "options": { "url": "hostname", "attributes": ["customerSegment"]}}'
```

**File based augment**

Request

```
POST /1.0/tenants/{{tenant-name}}/augments HTTP/1.1
Host: api.cxengage.net
Content-Type: application/json; charset=utf-8
Authorization: Bearer {{token}}
Cache-Control: no-cache
```

```json
{
    "service": "engine",
    "name": "rest augment api",
    "description": "description",
    "augment-service": "engine",
    "type": "file",
    "options": {
        "attributes": [
            "customerSegment", "twitter"
        ]
    }
}
```


Response

```json
{
    "service": "engine",
    "id": "AU2",
    "name": "rest augment api",
    "description": "description",
    "augment-service": "engine",
    "type": "file",
    "options": {
        "url": "hostname",
        "attributes": [
            "customerSegment"
        ]
    }
}
```


curl Example


```bash
curl -X POST https://api.cxengage.net/tenants/{{tenant-name}}/augment \
 -H 'Authorization: Bearer {{token}}' \
 -H 'Content-Type: application/json; charset=utf-8' \
 -d '{"service": "engine","id": "AU2","name": "rest augment api", 
      "description": "","augment-service": "engine","type": 
      "file","options": {"attributes": ["customerSegment", "twitter"]}}'
```

**Upload CSV for Augment**

**Upload File**

Request

```
POST /1.0/tenants/userevents/augments/AU1/file HTTP/1.1
Host: api.cxengage.net
Content-Type: text/csv
Authorization: Bearer {{token}}
```

```
username,email 
ryan,support@userevents.com
bob,admin@userevents.com
```

curl Example


```bash
curl -iX POST https://api.cxengage.net/1.0/tenants/userevents/augments/AU1/file  \ 
 -H 'Authorization: Bearer {{token}}' \
 -H 'Content-Type: text/csv' \
 -d @file.csv
```


**Retrieves augment for the given tenant**

Request

```http
GET /1.0/tenants/{{tenant-name}}/augments/{{augment-id}} HTTP/1.1
Host: api.cxengage.net
Content-Type: application/json
Authorization: Bearer {{token}}
Cache-Control: no-cache
```

Response

```json
{
    "id": "AU1",
    "name": "API based",
    "service": "engine",
    "type": "api",
    "options": {
        "url": "http://cxengage-augment",
        "attributes": [
            "phoneNumber",
            "customerSegment"
        ]
    }
}
```

curl Example


```bash
curl -X GET https://api.cxengage.net/tenants/{{tenant-name}}/augments/AU1 \
     -H 'Authorization: Bearer {{token}}'

```

## Generic Streaming Endpoint


An easy way to integrate generic external services into CxEngage is by using the generic streaming
endpoint (GSE). This endpoint allows the sending of any text data to all connected users by way of websockets.

### Sends

The GSE supports a single send **message** which accepts a single parameter of **body**

```clojure
(seq (send generic message {:body "Hello world"}))
```

Any connected web sockets for your tenant would receive the message *"Hello world"* upon executing the above
reaction.

Templating allows you to send more complicated formats, for example you could make a template which formats JSON:

```mustache
{"id" : "{{id}}"
 {{#name}}
 ,"name" : "{{name}}"
 {{/name}}}
```

The above template would create a JSON object which would extract the *id* field from the reaction context, and
if present in the context, add in the *name* field to the object.

Sending this message would be done as follows:

```clojure
(seq (send generic message {} (template {:body +TM1})))
```

Where **+TM1** refers to the above template.

### Connecting

To open a web socket to the GSE one must first obtain their oauth bearer token, and request a stream ticket.
Refer to the auth section for instructions on acquiring your oauth token.

A stream ticket can be acquired using the following request:

```http
POST /1.0/tenants/<tenantid>/ticket HTTP/1.1
Host: stream.cxengage.net
Authorization: Bearer <token>
```

Which results in the following response:

```json
{
    "ticket": "3eefbc28-ed3a-4c69-873d-8000bcd02f46"
}
```

The ticket provided is valid for a single use within 2 minutes of requesting and must be used by the same IP address which requested the ticket.

The ticket can then be used to open a web socket at the following address:

**ws://stream.cxengage.net/1.0/stream/<ticket>**

Sending data is not permitted on the socket, only receiving data.
The socket will be sent all notifications sent to in while connected. It is important to note
that if no sockets are connected when a notification is sent, the message will be discarded and
the notification will be counted as a success.

