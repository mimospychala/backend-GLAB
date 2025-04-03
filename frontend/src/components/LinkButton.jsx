import { Link } from "react-router"

import styles from "./LinkButton.module.css"

export default function LinkButton({ to, children, ...props }) {
    return (
        <Link to={to}>
            <button {...props}>
                {children}
            </button>
        </Link>
    )
}
