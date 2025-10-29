import { Route, Routes } from 'react-router-dom';

import NotFound from './pages/not-found/page';
import Home from './pages/home/page';
import Login from './pages/login/page';
import Register from './pages/register/page';

import NotesList from './pages/notes-list/page';
import NoteDetail from './pages/note-detail/page';
import Header from './layout/header';

function App() {
  return (
    <div className="App">
      <Header />

      <Routes>
        <Route index element={<Home />} />
        <Route path="/register" element={<Register />} />
        <Route path="/login" element={<Login />} />

        <Route path="/internal/notes" element={<NotesList />} />
        <Route path="/internal/note/:noteId" element={<NoteDetail />} />

        <Route path="*" element={<NotFound />} />
      </Routes>
    </div>
  );
}

export default App;
