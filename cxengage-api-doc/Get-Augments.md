## Augment Resources

```
  GET tenants/:iid/augments
```

## Description

Retrieves augments for the given tenant.


### Parameters

- **iid** _(required)_ — Selected tenant

### Errors

All known errors will be returned in a JSON map with key "error".

- **404 Not Found** - The requested tenant does not exist or has been deleted.

### Example

**Request**

```
GET /1.0/tenants/{{tenant-name}}/augments HTTP/1.1
Host: api.cxengage.net
Content-Type: application/json
Authorization: Bearer {{token}}
Cache-Control: no-cache

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
 
### curl Example

```
curl -X GET https://api.cxengage.net/tenants/{{tenant-name}}/augments \
     -H 'Authorization: Bearer {{token}}'

```
