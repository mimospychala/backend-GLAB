export default function NumNumRating({ rating }) {
    return (
        <>
            <div>
                <p>NomNomRating:</p>
                <div>{"⭐".repeat(rating)}</div>
            </div>
        </>
    )
}