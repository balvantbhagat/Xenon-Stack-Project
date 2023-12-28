<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>User Login</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
        rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
        crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
          integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
          crossorigin="anonymous"></script>
</head>
<body>
<div class="container py-5  ">
  <div class="row justify-content-center align-item-center">
    <div class="col-6   ">
      <form action="SaveServlet" method="post" class="border border-primary p-3">
        <div class="mb-3">
         <label  class="form-label">User Id</label>
         <input type="text" class="form-control"  placeholder="Enter User Id (Integer)" name="id">
              </div>
        <div class="mb-3">
          <label  class="form-label">First Name</label>
          <input type="text" class="form-control"  placeholder="Enter First Name" name="firstName">
        </div>
        <div class="mb-3">
          <label  class="form-label">Last Name</label>
          <input type="text" class="form-control"  placeholder="Enter Last Name" name="lastName">
        </div>
        <div class="mb-3">
          <label  class="form-label">City</label>
          <input type="text" class="form-control" placeholder="Enter City" name="city">
        </div>
        <div class="mb-3">
          <label  class="form-label">Age</label>
          <input type="text" class="form-control" placeholder="Enter Age" name="age">
         </div>
        <div class="d-flex justify-content-center">
          <button type="submit" class="d-flex btn btn-success mb-1 ">Submit</button>
        </div>
      </form>
      <div class="d-flex justify-content-center  p-2 m-2 ">
        <span><a href="userActions.html">Update User</a></span>
        <span><a href="userActions.html" class="p-5">Delete User</a></span>

      </div>
      <div class="d-flex justify-content-center  p-2 m-2 ">
        <span><a href="userActions.html" >Get User By Id</a></span>
        <span><a href="ShowAllUser.jsp" class="p-5">Show All Users</a></span>
        </div>
    </div>
  </div>
</div>
</body>
</html>
