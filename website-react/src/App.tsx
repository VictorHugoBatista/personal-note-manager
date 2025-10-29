import { Route, Routes } from 'react-router-dom';

import Page from './layout/page';
import Home from './pages/home/page';
import Login from './pages/login/page';
import NoteDetail from './pages/note-detail/page';
import NotesList from './pages/notes-list/page';
import NotFound from './pages/not-found/page';
import Register from './pages/register/page';

import "./dist/styles.css";

const App = () => (
    <Page>
      <Routes>
        <Route index element={<Home />} />
        <Route path="/register" element={<Register />} />
        <Route path="/login" element={<Login />} />

        <Route path="/internal/notes" element={<NotesList />} />
        <Route path="/internal/note/:noteId" element={<NoteDetail />} />

        <Route path="*" element={<NotFound />} />
      </Routes>
    </Page>
);

export default App;
