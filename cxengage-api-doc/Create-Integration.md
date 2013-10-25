## Integration Resources

```
  POST tenants/:iid/integrations/:id
```

## Description

Retrieves specific integration from the given tenant.


### Parameters

- **iid** _(required)_ — Selected tenant
- **id**  _(required)_ - Selected listener or endpoint

### Errors

All known errors will be returned in a JSON map with key "error".

- **404 Not Found** - The requested tenant does not exist or has been deleted.

### Example

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
    "username": "dev@userevents.com",
    "secret-token": "secret-token",
    "password": "password"
}

```

### curl Example

```
curl -XPOST http://api.cxengage.com/tenants/{{tenant-name}}/integrations/twilio \
     -H 'Authorization: Bearer {{token}}' \
-H 'Content-Type: application/json; charset=utf-8' \
-d '{"id": "twilio", "account": "{{account-sid}}", "password": "{{auth-token}}"}'

```
