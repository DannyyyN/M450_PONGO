// @ts-ignore

Cypress.Commands.add('login', () => {
  // Send a login request
  cy.request({
    method: 'POST',
    url: `${Cypress.env('API_URL')}/user/login`, // Adjust the URL to match your login endpoint
    body: {
      email: 'admin@example.com',
      password: '1234',
    },
  }).then((response) => {
    console.log(response);  // Log the response to inspect it
    // Extract and save the token and user data from the response
    const { token, user } = response.body;
    window.localStorage.setItem('token', 'Bearer ${token}');
    window.localStorage.setItem('user', JSON.stringify(user));
  });
  cy.window().its('localStorage').invoke('getItem', 'token').should('include', 'Bearer');
  cy.window().its('localStorage').invoke('getItem', 'user').should('not.be.null');
});

beforeEach(() => {
  cy.login()
});

describe('Login', () => {
  it('Visits the login page', () => {
    cy.visit(`${Cypress.env('BASE_URL')}/login/`);

    cy.contains('Sign In');

    cy.get('input[id=email]').type('admin@example.com');
    cy.get('input[id=password]').type('1234');
    cy.get('[id=signIn]').click();
    cy.visit(`${Cypress.env('BASE_URL')}/profile`);
    cy.reload();
  });
});
describe('CRUD', () => {
  it('Creates an item', () => {
    cy.visit(`${Cypress.env('BASE_URL')}/profile`);

    cy.contains('Welcome');
    cy.contains('Add').click();

    cy.visit(`${Cypress.env('BASE_URL')}/itemedit/`);

    cy.get('input[id=name]').type('Aryan Phone');
    cy.get('input[id=pictureURL]').type('https://scontent-fra5-2.xx.fbcdn.net/v/t39.30808-6/298803267_752102452891770_203060016891199193_n.jpg?_nc_cat=102&ccb=1-7&_nc_sid=5f2048&_nc_ohc=dEgtXTl-ICUAX-fO3iJ&_nc_ht=scontent-fra5-2.xx&oh=00_AfA7STSHqdiqEwkL9PGdfPQHWoGqkGFYcnKpaBGW0XvQ9A&oe=6545A834');
    cy.get('input[id=description]').type('Aryan style phone');
    cy.get('input[id=price]').type('800');
    cy.contains('Finish').click();
    cy.visit(`${Cypress.env('BASE_URL')}/item`);
    cy.reload();
  });
  it('See all profiles', () => {

    cy.visit(`${Cypress.env('BASE_URL')}/profile`);

    cy.contains('Welcome');
    cy.get('.openDrawer').click();
    cy.contains('Articles').click();

    cy.visit(`${Cypress.env('BASE_URL')}/item`);

    cy.reload();

    cy.contains('Aryan Phone');
    cy.contains('Back').click();
    cy.visit(`${Cypress.env('BASE_URL')}/profile`);
  });

  it('Edit an item', () => {

    cy.visit(`${Cypress.env('BASE_URL')}/profile`);

    cy.contains('Welcome');
    cy.get('.openDrawer').click();
    cy.contains('Articles').click();

    cy.visit(`${Cypress.env('BASE_URL')}/item`);

    cy.reload();

    cy.contains('Aryan Phone').click();
    cy.contains('Edit').click({multiple: true});
    cy.get('input[id=name]').clear().type('Arbon Phone');
    cy.get('input[id=pictureURL]').clear().type('https://feinekekse.web.app/images/Aryan.jpg');
    cy.get('input[id=description]').clear().type('Arbon style phone');
    cy.get('input[id=price]').clear().type('60');
    cy.contains('Save').click();
    cy.visit(`${Cypress.env('BASE_URL')}/item`)
  });

  it('Delete an item', () => {

    cy.visit(`${Cypress.env('BASE_URL')}/profile`);

    cy.contains('Welcome');

    cy.reload();

    cy.contains('Delete').click({multiple: true})

  });
});

describe('Logout', () => {
  it('Logout', () => {
    cy.visit(`${Cypress.env('BASE_URL')}/profile`);

    cy.contains('Welcome');

    cy.contains('Logout').click();
    cy.visit(`${Cypress.env('BASE_URL')}/`)
  })
});