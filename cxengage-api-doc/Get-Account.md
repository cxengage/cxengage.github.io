```
GET /account
```

## Description

Retrieves account information

### Authentication

[OAuth](https://github.com/userevents/charon)

All known errors will be returned in a JSON map with key "error".

- **403 Forbidden** - You do not have access to the instance or OAuth error - see [OAuth](https://github.com/userevents/charon) for more information.

### Example

**Request**

```
  GET /account
```

**Return**

```json
[
  {
    "email": "admin@userevents.com",
    "username": "admin"
  }
]
```
