import React from 'react'

export default function RegisterForm() {
  return (
    <form>
        <div class="form-group">
          <label for="email">Email</label>
          <input type="email" class="form-control" id="email" />
        </div>

        <div class="form-group">
          <label for="username">Username</label>
          <input type="text" class="form-control" id="username" />
        </div>

        <div class="form-group">
          <label for="password">Password</label>
          <input type="password" class="form-control" id="password" />
        </div>

        <div class="form-group">
          <label for="verifyPassword">Verify Password</label>
          <input type="password" class="form-control" id="verifyPassword" />
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
      </form>
  )
}
