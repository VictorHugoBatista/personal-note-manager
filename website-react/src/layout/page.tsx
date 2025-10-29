import { ReactNode } from "react";

import Footer from "./footer";
import Header from "./header";

interface Props {
  children: ReactNode;
}

const Page = ({ children }: Props) => (
  <div className="flex flex-col bg-amber-50">
    <Header />

    <div className="container mx-auto">
      {children}
    </div>

    <Footer />
  </div>
);

export default Page;
