## Integration Resources

## Description


Posts specific integration for the given tenant.

### Errors

All known errors will be returned in a JSON map with key "error".

- **422 Unprocessable Entity** - The requested tenant or item does not exist or has been deleted.

## Salesforce Parameters

- **secret-token** - [Get Salesforce secret token](https://help.salesforce.com/apex/HTViewHelpDoc?id=user_security_token.htm&language=en)
- **username** - Salesforce username
- **password** - Salesforce password
- **consumer-key** - [Get Salesforce Consumer key/secret](http://www.salesforce.com/us/developer/docs/api_streaming/Content/code_sample_auth_oauth.htm)
- **consumer-secret** - [Get Salesforce Consumer key/secret](http://www.salesforce.com/us/developer/docs/api_streaming/Content/code_sample_auth_oauth.htm)


### Request

```http
POST /1.0/tenants/{{tenant-name}}/salesforce HTTP/1.1
Host: api.cxengage.net
Content-Type: application/json; charset=utf-8
Authorization: Bearer {{token}}
```

## Examples for setting up Salesforce, Twilio, SendGrid and Datasift integrations

### Salesforce Example

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

**Return**

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


### curl Example

```bash
curl -XPOST https://api.cxengage.net/1.0/tenants/{{tenant-name}}/integrations/salesforce \
     -H 'Authorization: Bearer {{token}}' \
-H 'Content-Type: application/json; charset=utf-8' \
-d '{"id": "salesforce", "type": "salesforce", "consumer-key": "consumerkey", "consumer-secret":"consumersecret","username":"email@userevents.com"
"secret-token":"secret-token","password":"password"}'

```

### Twilio Example

**Request**

```http
POST /1.0/tenants/{{tenant-name}}/twilio HTTP/1.1
Host: api.cxengage.net
Content-Type: application/json; charset=utf-8
Authorization: Bearer {{token}}
```

### Twilio Parameters
- **account** - Twilio SID
- **password** - [Twilio Token](https://www.twilio.com/help/faq/twilio-basics/what-is-the-auth-token-and-how-can-it-be-reset)


```json
{
    "id": "twilio",
    "account": "SID",
    "password": "Token"
}

```

**Return**

```json

{
    "id": "twilio",
    "account": "SID",
    "password": "Token"
}

```

### curl Example

```bash
curl -XPOST https://api.cxengage.net/1.0/tenants/{{tenant-name}}/integrations/twilio \
     -H 'Authorization: Bearer {{token}}' \
-H 'Content-Type: application/json; charset=utf-8' \
-d '{"id": "twilio", "type": "twilio", "account": "SID", "password":"Token"}'
```

### Sendgrid Example

### Sendgrid Parameters
- **account** - SendGrid account 
- **password** - Sendgrid password


**Request**

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

**Return**

```json

{
    "id": "sendgrid",
    "account": "username",
    "password": "password"
}

```

### curl Example

```bash
curl -XPOST https://api.cxengage.net/1.0/tenants/{{tenant-name}}/integrations/sendgrid \
     -H 'Authorization: Bearer {{token}}' \
-H 'Content-Type: application/json; charset=utf-8' \
-d '{"id": "sendgrid", "type": "sendgrid", "account": "username", "password":"password"}'

```

### Datasift Example

### Datasift Parameters
- **username** - DataSift username
- **api-key** - [DataSift api key](http://dev.datasift.com/docs/getting-started/api-faq#APIkey)


**Request**

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

**Return**

```json

{
    "id": "datasift",
    "api-key": "api-key",
    "username": "username"
}

```

### curl Example

```bash
curl -XPOST https://api.cxengage.net/1.0/tenants/{{tenant-name}}/integrations/datasift \
     -H 'Authorization: Bearer {{token}}' \
-H 'Content-Type: application/json; charset=utf-8' \
-d '{"id": "datasift", "type": "datasift", "api-key": "api-key", "username":"username"}'

```


