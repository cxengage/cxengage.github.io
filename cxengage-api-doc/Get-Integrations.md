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
  GET /tenants/tenant1/integrations
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
curl -XGET http://api.cxengage.com/tenants/{{tenant-name}}/integrations \
     -H 'Authorization: Bearer {{token}}'
```

