# Instance Resources

```
  GET /account/tenants
```

## Description

Retrieves all instances for the CxEngage installation that the user is authorized for

### Authentication 

[OAuth](https://github.com/userevents/charon)

### Parameters

### Errors
All known errors will be returned in a JSON map with key "error".

- **403 Forbidden** - You do not have access to the instance or OAuth error - see [OAuth](https://github.com/userevents/charon) for more information.

### Example

**Request**

```
  GET account/tenants
```

**Return**

```json
[
 {
  "id": "IN1"
  "name": "Engineering"
 }

 {
  "id": "IN2"
  "name": "Sales"
 }
]

```
