## Integration Resources

```
  GET tenants/:iid/integrations/:id
```

## Description

Retrieves specific integration from the given tenant


### Parameters

- **iid** _(required)_ — Selected tenant
- **id** _(required)_ - Selected integration

### Errors

All known errors will be returned in a JSON map with key "error".

- **404 Not Found** - The requested tenant does not exist or has been deleted.

### Example

**Request**

```
GET /1.0/tenants/{{tenant-name}}/integrations/{{integration}} HTTP/1.1
Host: api.cxengage.net
Content-Type: application/json
Authorization: Bearer {{token}}
Cache-Control: no-cache
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

### curl Example

```
curl -XGET https://api.cxengage.net/tenants/{{tenant-name}}/integrations/twilio \
     -H 'Authorization: Bearer {{token}}'
```

