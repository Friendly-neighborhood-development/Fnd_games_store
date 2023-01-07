import {MainLayout} from "../components/layouts/MainLayout";
import {useAppSelector} from "../hooks/redux";
import {Link} from "react-router-dom";

const Cart = () => {
    const {isAuth} = useAppSelector(state => state.auth)
    return (
        <MainLayout>
            {isAuth
                ? <div>Here will be your cart items..</div>
                : <div className={"flex justify-center text-xl"}>
                    <Link to={"/login"} className={" mr-1 text-blue-600 dark:text-sky-500"}>Login</Link>to use the cart
                </div>
            }
        </MainLayout>);
};


export default Cart
