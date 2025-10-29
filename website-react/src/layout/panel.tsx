import { ReactNode } from "react";

interface Props {
  children: ReactNode;
}

const Panel = ({ children }: Props) => (
  <header className="flex justify-left m-3 p-5 shadow-xl rounded-md bg-white/75">
    <div className="container mx-auto">
      {children}
    </div>
  </header>
);

export default Panel;
