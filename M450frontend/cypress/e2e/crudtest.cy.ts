// @ts-ignore

Cypress.Commands.add('login', () => {
  window.localStorage.setItem('token', "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdXRob3JpdGllcyI6W3siYXV0aG9yaXR5IjoiREVGQVVMVCJ9LHsiYXV0aG9yaXR5IjoiVVNFUl9ERUxFVEUifSx7ImF1dGhvcml0eSI6IlVTRVJfTU9ESUZZIn1dLCJzdWIiOiJiYTgwNGNiOS1mYTE0LTQyYTUtYWZhZi1iZTQ4ODc0MmZjNTQiLCJpYXQiOjE2OTg3NDI4MzgsImV4cCI6MTY5ODg0MjgzOCwiaXNzIjoidWsyMjMifQ.pFpWcdV1dcB-0d-BFaSwa4H6Wqtdpjk3klBKHF5b3A0");
  window.localStorage.setItem('user', "{\"id\":\"ba804cb9-fa14-42a5-afaf-be488742fc54\",\"firstName\":\"James\",\"lastName\":\"Bond\",\"email\":\"admin@example.com\",\"roles\":[{\"id\":\"ab505c92-7280-49fd-a7de-258e618df074\",\"name\":\"USER_MODIFY\",\"authorities\":[{\"id\":\"76d2cbf6-5845-470e-ad5f-2edb9e09a868\",\"name\":\"USER_MODIFY\"}]},{\"id\":\"c6aee32d-8c35-4481-8b3e-a876a39b0c02\",\"name\":\"USER_DELETE\",\"authorities\":[{\"id\":\"21c942db-a275-43f8-bdd6-d048c21bf5ab\",\"name\":\"USER_DELETE\"}]},{\"id\":\"d29e709c-0ff1-4f4c-a7ef-09f656c390f1\",\"name\":\"DEFAULT\",\"authorities\":[{\"id\":\"2ebf301e-6c61-4076-98e3-2a38b31daf86\",\"name\":\"DEFAULT\"}]}]}")
});

beforeEach(() => {
  cy.login()
});

describe('Navigate to Profile Page', () => {
  it('Visits the login page', () => {
    cy.visit('http://localhost:3000/login/');

    cy.contains('Sign In');

    cy.get('input[id=email]').type('admin@example.com');
    cy.get('input[id=password]').type('1234');
    cy.get('[id=signIn]').click();
    cy.visit('http://localhost:3000/profile')
  });

  it('Creates an item', () => {
    cy.visit('http://localhost:3000/profile');

    cy.contains('Welcome');
    cy.contains('Add').click();

    cy.visit('http://localhost:3000/itemedit/');

    cy.get('input[id=name]').type('Aryan Phone');
    cy.get('input[id=pictureURL]').type('https://scontent-fra5-2.xx.fbcdn.net/v/t39.30808-6/298803267_752102452891770_203060016891199193_n.jpg?_nc_cat=102&ccb=1-7&_nc_sid=5f2048&_nc_ohc=dEgtXTl-ICUAX-fO3iJ&_nc_ht=scontent-fra5-2.xx&oh=00_AfA7STSHqdiqEwkL9PGdfPQHWoGqkGFYcnKpaBGW0XvQ9A&oe=6545A834');
    cy.get('input[id=description]').type('Aryan style phone');
    cy.get('input[id=price]').type('800');
    cy.contains('Finish').click();
    cy.visit('http://localhost:3000/item')
  });

  it('See all profiles', () => {
    cy.visit('http://localhost:3000/profile');

    cy.contains('Welcome');
    cy.get('.openDrawer').click();
    cy.contains('Articles').click();

    cy.visit('http://localhost:3000/item');

    cy.contains('Aryan Phone');
    cy.contains('Back').click();
    cy.visit('http://localhost:3000/profile')
  });

  it('Edit an item', () => {
    cy.visit('http://localhost:3000/profile');

    cy.contains('Welcome');
    cy.get('.openDrawer').click();
    cy.contains('Articles').click();

    cy.visit('http://localhost:3000/item');

    cy.contains('Aryan Phone').click();
    cy.contains('Edit').click({ multiple: true });
    cy.get('input[id=name]').clear().type('Arbon Phone');
    cy.get('input[id=pictureURL]').clear().type('https://feinekekse.web.app/images/Aryan.jpg');
    cy.get('input[id=description]').clear().type('Arbon style phone');
    cy.get('input[id=price]').clear().type('60');
    cy.contains('Save').click();
    cy.visit('http://localhost:3000/item')
  });

  it ('Delete an item', () => {
    cy.visit('http://localhost:3000/profile');

    cy.contains('Welcome');
    cy.contains('Delete').click({ multiple: true })

  });


  it('Logout', () => {
    cy.visit('http://localhost:3000/profile');

    cy.contains('Welcome');

    cy.contains('Logout').click();
    cy.visit('http://localhost:3000/')
  })
});