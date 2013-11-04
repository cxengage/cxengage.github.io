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
  GET /tenants/tenant1/augments/AU8
```

```json
{
    "id": "AU8",
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
curl -X GET http://api.cxengage.com/tenants/{{tenant-name}}/augments/AU8 \
     -H 'Authorization: Bearer {{token}}'

```
