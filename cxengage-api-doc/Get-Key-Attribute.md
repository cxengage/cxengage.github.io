## Key Attribute Resources

```
  GET tenants/:iid/key-attribute
```

## Description

Retrieves key attribute for the given tenant.


### Parameters

- **iid** _(required)_ — Selected tenant

### Errors

All known errors will be returned in a JSON map with key "error".

- **404 Not Found** - The requested tenant does not exist or has been deleted.

### Example

**Request**

```
  GET /tenants/tenant-one/key-attribute
```

```json
{
    "key": "id"
}
```
 
### curl Example

```
curl -X GET http://api.cxengage.com/tenants/{{tenant-name}}\key-attribute \
     -H 'Authorization: Bearer {{token}}'

```
