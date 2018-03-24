import React from 'react';
import {Navbar, Nav, NavItem, NavDropdown, MenuItem, FormGroup, FormControl} from 'react-bootstrap';

class BlogNavbar extends React.Component {
    render() {
        return (
            <Navbar>
  <Nav>
    <NavDropdown eventKey={3} title="Blogs" id="basic-nav-dropdown">
      <MenuItem eventKey={3.1}>New</MenuItem>
      <MenuItem eventKey={3.2}>Edit</MenuItem>
      <MenuItem eventKey={3.3}>Save</MenuItem>
  </NavDropdown>

    <NavItem eventKey={1} href="#">
      Most Viewed
    </NavItem>

  <Navbar.Form pullLeft>
  <FormGroup>
      <FormControl type="text" placeholder="Search" />
  </FormGroup>{' '}
  </Navbar.Form>

  </Nav>
  <Nav pullRight>
      <NavItem eventKey={1} href="#">
          Login
      </NavItem>
  </Nav>
</Navbar>
        );
    }
}

export default BlogNavbar;
