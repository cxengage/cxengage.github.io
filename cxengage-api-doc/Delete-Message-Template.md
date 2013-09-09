# List Resources

```
  DELETE instance/:iid/message_templates/:id
```

## Description

Deletes the list from the given instance.

### Authentication

[OAuth](https://github.com/userevents/charon)

### Parameters

- **iid** _(required)_ — Selected instance
- **id** _(required)_ — List to delete

### Errors

All known errors will be returned in a JSON map with key "error".

- **403 Forbidden** - You do not have access to the instance or OAuth error - see [OAuth](https://github.com/userevents/charon) for more information.
- **404 Not Found** - The requested list or instance does not exist or has already been deleted.

### Example

**Request**

```
  DELETE instance/IN1/message_templates/MT1
```

**Return**

```json
{

  "MT1"
  
}
```
