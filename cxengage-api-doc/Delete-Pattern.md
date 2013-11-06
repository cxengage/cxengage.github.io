# Pattern Resources

```
  DELETE tenants/:iid/patterns/:id
```

## Description

Deletes the node from the given tenant.

### Parameters

- **iid** _(required)_ — Selected tenant
- **id** _(required)_ — Pattern to delete

### Errors

All known errors will be returned in a JSON map with key "error".

- **404 Not Found** - The requested tenant or pattern does not exist or has already been deleted.

### Example

**Request**

```
DELETE /1.0/tenants/{{tenant-name}}/patterns/PT21 HTTP/1.1
Host: api.cxengage.net
Content-Type: application/json
Authorization: Bearer {{token}}
Cache-Control: no-cache

```

**Return**

```json

{
 "id":"PT10"
}

```

```
curl -IX DELETE https://api.cxengage.net/tenants/{{tenant-name}}/patterns/PT21 \
 -H 'Authorization: Bearer {{token}}' 
```
