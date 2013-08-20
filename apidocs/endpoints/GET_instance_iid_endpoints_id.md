# Endpoint Resources

```
  GET instance/:iid/endpoints/:id
```

## Description

Retrieves all endpoints for the given instance

### Authentication

[OAuth](https://github.com/userevents/charon)

### Parameters

- **iid** _(required)_ — Selected instance
- **id** _(required)_ — Node to retrieve

### Errors

All known errors will be returned in a JSON map with key "error".

- **403 Forbidden** - You do not have access to the instance or OAuth error - see [OAuth](https://github.com/userevents/charon) for more information.

### Example

**Request**

```
  GET instance/:iid/endpoints/:id
```

**Return**

```json
{
   "id":"EP1",
   "name":"echo",
   "display":"Echo Endpoint",
   "params":[],
   "ui":[
        "quote",
         []],
      "sends": {
        "message": {
           "message": {               
               "type":"optional"
           }
        }
    }
}
  
```
