## Key Attribute Resources

```
  POST tenants/:iid/key-attribute
```

## Description

Retrieves key attribute for the given tenant.


### Parameters

- **iid** _(required)_ — Selected tenant

### Errors

All known errors will be returned in a JSON map with key "error".

- **404 Not Found** - The requested tenant does not exist or has been deleted.

### Content Type

```
Content-Type: application/json; charset=utf-8
```

### Example

**Request**

```
POST /tenants/{{tenant-name}}/key-attribute HTTP/1.1
Host: {{cxenage-api}}
Content-Type: application/json; charset=utf-8
Authorization: Bearer {{token}}
Cache-Control: no-cache
```

```json
{
    "key": "username"
}
```
 
### curl Example

```
curl -X POST https://api.cxengage.net/tenants/{{tenant-name}}/key-attribute \
 -H 'Authorization: Bearer {{token}}' \
 -H 'Content-Type: application/json; charset=utf-8' \
 -d '{"key" : "username"}' 
```

