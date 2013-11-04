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
  GET /tenants/tenant1/augments
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
