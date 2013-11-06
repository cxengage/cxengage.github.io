## Integration Resources

```
  GET tenants/:iid/integrations
```

## Description

Retrieves integrations for the given tenant.


### Parameters

- **iid** _(required)_ — Selected tenant


### Errors

All known errors will be returned in a JSON map with key "error".

- **404 Not Found** - The requested tenant does not exist or has been deleted.

### Example

**Request**

```
GET /1.0/tenants/{{tenant-name}}/integrations HTTP/1.1
Host: api.cxengage.net
Content-Type: application/json
Authorization: Bearer {{token}}
Cache-Control: no-cache
```

```json
[
  {
    "id": "datasift",
    "api-key": "keyvalue",
    "username": "usernamevalue"
}

    {
        "id": "echo"
    }
]
```

### curl Example

```
curl -XGET https://api.cxengage.net/tenants/{{tenant-name}}/integrations \
     -H 'Authorization: Bearer {{token}}'
```

