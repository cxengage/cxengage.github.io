# Tenant Resources

```
  GET /tenants
```

## Description

Retrieves tenant info


### Errors

All known errors will be returned in a JSON map with key "error".

### Example

**Request**

```
  GET /tenants
```

**Return**

```json

[
    {
        "id": "tenant-two",
        "name" : "another tenant"
    },
    {
        "id": "tenant1",
        "name": "Tenant Number One"
    }
]

```


