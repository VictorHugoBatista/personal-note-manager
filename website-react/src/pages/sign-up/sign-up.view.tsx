import Panel from "../../layout/panel";

const SignUpView = () => {
  return (
    <div className="-mx-3 h-full flex">
      <Panel extraStyles="flex-col flex-1 justify-center items-center w-full">
        <h2 className="text-2xl mb-5">Sign up</h2>

        <form action="" className="flex flex-col w-full max-w-100">
          <div className="flex mb-4">
            <label htmlFor="input-email" className="mr-3 flex items-center">Email</label>
            <input type="text" id="input-email" name="email" className="bg-white inset-shadow-sm inset-shadow-gray-300 py-2 px-3 flex-1 rounded-md" />
          </div>
          <div className="flex mb-4">
            <label htmlFor="input-password" className="mr-3 flex items-center">Password</label>
            <input type="password" id="input-password" name="password" className="bg-white inset-shadow-sm inset-shadow-gray-300 py-2 px-3 flex-1 rounded-md" />
          </div>
          <input className="inline-block m-2 py-3 px-4 rounded-sm bg-blue-500 text-white text-xl shadow-md shadow-blue-300 transition duration-200 ease-in-out hover:bg-blue-200 hover:shadow-xl hover:scale-110"
            type="submit"
            value="Sign up" />
        </form>
      </Panel>
    </div>
  );
};

export default SignUpView;
