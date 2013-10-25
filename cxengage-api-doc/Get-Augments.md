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
{
    "key": "id"
}
```
 
### curl Example

```
curl -X GET http://api.cxengage.com/tenants/{{tenant-name}}/augments \
     -H 'Authorization: Bearer {{token}}'

```
