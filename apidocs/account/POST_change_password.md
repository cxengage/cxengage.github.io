# Account Resources

``` 
POST /account/change_password
```

## Description

Change account password

### Authentication

[OAuth](https://github.com/userevents/charon)

### Parameters

- **password** 


### Errors

All known errors will be returned in a JSON map with key "error".

- **403 Forbidden** - You do not have access to the instance or OAuth error - see [OAuth](https://github.com/userevents/charon) for more information.

### Example

**Request**

```
  POST account/change_password
  Content-Type: application/json
```

```json
{
 "password": "password"
}
```

**Return**

```json
{ 
  "status": "true"
}
```
  

