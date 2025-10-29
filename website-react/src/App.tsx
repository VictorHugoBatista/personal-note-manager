import { Route, Routes } from 'react-router-dom';

import Header from './layout/header';
import Footer from './layout/footer';
import Home from './pages/home/page';
import Login from './pages/login/page';
import NoteDetail from './pages/note-detail/page';
import NotesList from './pages/notes-list/page';
import NotFound from './pages/not-found/page';
import Register from './pages/register/page';

import "./dist/styles.css";


function App() {
  return (
    <div className="flex flex-col bg-amber-50">
      <Header />

      <div className="container mx-auto">
        <Routes>
          <Route index element={<Home />} />
          <Route path="/register" element={<Register />} />
          <Route path="/login" element={<Login />} />

          <Route path="/internal/notes" element={<NotesList />} />
          <Route path="/internal/note/:noteId" element={<NoteDetail />} />

          <Route path="*" element={<NotFound />} />
        </Routes>
      </div>

      <Footer />
    </div>
  );
}

export default App;
