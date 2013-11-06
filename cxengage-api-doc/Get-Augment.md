## Augment Resources

```
  GET tenants/:iid/augments/:aid
```

## Description

Retrieves augments for the given tenant.


### Parameters

- **iid** _(required)_ — Selected tenant
- **aid** _(required)_ — Selected Augment

### Errors

All known errors will be returned in a JSON map with key "error".

- **404 Not Found** - The requested tenant does not exist or has been deleted.

### Example

**Request**

```
GET /1.0/tenants/{{tenant-name}}/augments/AU1 HTTP/1.1
Host: api.cxengage.net
Content-Type: application/json
Authorization: Bearer {{token}}
Cache-Control: no-cache
```

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
 
### curl Example

```
curl -X GET https://api.cxengage.net/tenants/{{tenant-name}}/augments/AU1 \
     -H 'Authorization: Bearer {{token}}'

```
