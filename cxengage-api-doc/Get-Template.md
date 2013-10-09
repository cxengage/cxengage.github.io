## Template Resources

```
  GET tenants/:iid/templates/:id
```

## Description

Retrieves templates for the given instance.


### Parameters

- **iid** _(required)_ — Selected tenants
- **id** _(required)_ - Selected template

### Errors

All known errors will be returned in a JSON map with key "error".

- **404 Not Found** - The requested tenant or template does not exist or has been deleted.

### Example

**Request**

```
  GET tenants/tenant1/templates/TM1
```

```json

    {
        "id": "TM1",
        "template": "Hi {{FirstName}}, sorry we missed your call. Call Joe at
+14153159430 re: 401K needs. Gelson Bank.",
        "description": "Default SMS message with click-to-call",
        "name": "SMS"
    }
```
