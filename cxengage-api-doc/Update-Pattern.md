# Pattern Resources

```
  POST tenants/:iid/patterns/:id
```

## Description

Updates the pattern for the given instance based on the pattern id given

### Authentication

[OAuth](https://github.com/userevents/charon)

### Parameters

- **iid** _(required)_ — Selected tenant
- **id** _(required)_ — Pattern id

### Errors

All known errors will be returned in a JSON map with key "error".

- **403 Forbidden** - You do not have access to the instance or OAuth error - see [OAuth](https://github.com/userevents/charon) for more information.
- **404 Not Found** - The requested node or instance does not exist or has been deleted.

### Example

**Request**

```
  POST tenants/tenant1/patterns/PT1
```

```json
{
 "id":"PT1",
 "then":"(seq (send echo message {:message \"Hello world\"}))",
 "when":"(when (event (= \"id\" \"1234\")))",
 "status":true,
 "description":"Updated Sample Pattern",
 "name":"Sample Pattern"}
```

**Return**

```json

{
  "id":"PT1",
  "then":"(seq (send echo message {:message \"Hello world\"}))",
  "when":"(when (event (= \"id\" \"1234\")))",
  "status":true,
  "description":"Updated Sample Pattern",
  "name":"Sample Pattern"
}
```

