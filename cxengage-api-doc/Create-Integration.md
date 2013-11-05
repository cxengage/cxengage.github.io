## Integration Resources

```
  POST tenants/:iid/integrations/:id
```

## Description


Posts specific integration for the given tenant.


### Parameters

- **iid** _(required)_ — Selected tenant
- **id**  _(required)_ - Selected listener or endpoint

### Errors

All known errors will be returned in a JSON map with key "error".

- **404 Not Found** - The requested tenant does not exist or has been deleted.

### Request

```
POST /1.0/tenants/{{tenant-name}}/datasift HTTP/1.1
Host: api.cxengage.net
Content-Type: application/json; charset=utf-8
Authorization: Bearer {{token}}
Cache-Control: no-cache
```

## Examples for setting up Salesforce, Twilio, Sendgrid and Datasift integrations

### Salesforce Example

**Request**

```
  POST /tenants/tenant1/integrations/salesforce
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

```
curl -XPOST https://api.cxengage.net/tenants/{{tenant-name}}/integrations/salesforce \
     -H 'Authorization: Bearer {{token}}' \
-H 'Content-Type: application/json; charset=utf-8' \
-d '{"id": "salesforce", "type": "salesforce", "consumer-key": "consumerkey", "consumer-secret":"consumersecret","username":"email@userevents.com"
"secret-token":"secret-token","password":"password"}'

```

### Twilio Example

**Request**

```
  POST /tenants/{{tenant-name}}/integrations/twilio
```

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

```
curl -XPOST https://api.cxengage.net/tenants/{{tenant-name}}/integrations/twilio \
     -H 'Authorization: Bearer {{token}}' \
-H 'Content-Type: application/json; charset=utf-8' \
-d '{"id": "twilio", "type": "twilio", "account": "SID", "password":"Token"}'

```

### Sendgrid Example

**Request**

```
  POST /tenants/{{tenant-name}}/integrations/sendgrid
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

```
curl -XPOST https://api.cxengage.net/tenants/{{tenant-name}}/integrations/sendgrid \
     -H 'Authorization: Bearer {{token}}' \
-H 'Content-Type: application/json; charset=utf-8' \
-d '{"id": "sendgrid", "type": "sendgrid", "account": "username", "password":"password"}'

```

### Datasift Example

**Request**

```
  POST /tenants/{{tenant-name}}/integrations/datasift
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

```
curl -XPOST https://api.cxengage.net/tenants/{{tenant-name}}/integrations/datasift \
     -H 'Authorization: Bearer {{token}}' \
-H 'Content-Type: application/json; charset=utf-8' \
-d '{"id": "datasift", "type": "datasift", "api-key": "api-key", "username":"username"}'

```


