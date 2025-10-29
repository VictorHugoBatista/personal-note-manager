enum PageRoute {
  HOME = '/',
  SIGN_IN = '/sign-in',
  SIGN_UP = '/sign-up',
  NOTES_LIST = '/internal/notes',
  NOTE_DETAIL = '/internal/note/:noteId',
  NOT_FOUND = '*',
}

export default PageRoute;
