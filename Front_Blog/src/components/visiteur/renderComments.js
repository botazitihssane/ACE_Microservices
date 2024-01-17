/* eslint-disable no-undef */
const renderComments = (comment) => {
  return (
    <div key={comment.id} className="d-flex mb-4">
      <div className="flex-shrink-0"></div>
      <div className="ms-3">
        <div className="fw-bold">{comment.visiteur?.nom || "Anonymous"}</div>
        <div>{comment.texte}</div>
        <div className="mt-2">
          <button
            className="btn btn-secondary btn-sm"
            onClick={() => handleReply(comment)}
          >
            Reply
          </button>
        </div>
        {comment.replies && comment.replies.length > 0 && (
          <div className="d-flex mt-4">
            {comment.replies.map((reply) => (
              <div key={reply.id} className="ms-3">
                {renderComments(reply)}
              </div>
            ))}
          </div>
        )}
      </div>
    </div>
  );
};
