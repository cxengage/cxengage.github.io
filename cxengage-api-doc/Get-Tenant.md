# Tenant Resources

```
  GET /tenants/:tid
```

## Description

Retrieves tenant info


### Parameters

- **tid** _(required)_ — Selected tenant

### Errors

All known errors will be returned in a JSON map with key "error".

### Example

**Request**

```
  GET /tenants
```

**Return**

```json

{
    "id": "tenant1",
    "name": "Tenant Number One"
}

```


