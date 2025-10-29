import { Route, Routes } from 'react-router-dom';

import Page from './layout/page';
import Home from './pages/home/page';
import NoteDetail from './pages/note-detail/page';
import NotesList from './pages/notes-list/page';
import NotFound from './pages/not-found/page';
import PageRoute from './pages/page-route';
import SignIn from './pages/sign-in/page';
import SignUp from './pages/sign-up/page';

import "./dist/styles.css";

const App = () => (
    <Page>
      <Routes>
        <Route index element={<Home />} />
        <Route path={PageRoute.SIGN_IN} element={<SignIn />} />
        <Route path={PageRoute.SIGN_UP} element={<SignUp />} />

        <Route path={PageRoute.NOTES_LIST} element={<NotesList />} />
        <Route path={PageRoute.NOTE_DETAIL} element={<NoteDetail />} />

        <Route path={PageRoute.NOT_FOUND} element={<NotFound />} />
      </Routes>
    </Page>
);

export default App;
